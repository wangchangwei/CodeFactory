package cn.afterturn.gen.modular.code.controller;

import cn.afterturn.gen.core.model.GenBeanEntity;
import cn.afterturn.gen.core.model.GenFieldEntity;
import cn.afterturn.gen.core.model.GenerationEntity;
import cn.afterturn.gen.core.model.ResponseModel;
import cn.afterturn.gen.core.parse.ParseFactory;
import cn.afterturn.gen.core.shiro.ShiroKit;
import cn.afterturn.gen.core.util.DateUtil;
import cn.afterturn.gen.modular.code.model.GenParamModel;
import cn.afterturn.gen.modular.code.model.TemplateGroupModel;
import cn.afterturn.gen.modular.code.model.TemplateModel;
import cn.afterturn.gen.modular.code.model.dto.EolinkData;
import cn.afterturn.gen.modular.code.model.eolink.JsonRootBean;
import cn.afterturn.gen.modular.code.model.eolink.Param_list;
import cn.afterturn.gen.modular.code.model.eolink.Request_info;
import cn.afterturn.gen.modular.code.model.eolink.Result_info;
import cn.afterturn.gen.modular.code.service.IGenParamService;
import cn.afterturn.gen.modular.code.service.IGenService;
import cn.afterturn.gen.modular.code.service.ITemplateService;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("eolink")
public class EolinkController {
    private String PREFIX = "/code/gen/";

    private static  final String Eo_Secret_Key = "VsP9tkMf7e02486acf210689f8ef43b63729a39029e0a66";

    private static final String URL = "https://api.eolink.com/v2/api_studio/management/api/api_info";

    @Autowired
    private ITemplateService templateService;

    @Autowired
    private IGenService genService;

    /**
     * 跳转到首页
     */
  @RequestMapping("/review_code_api")
    public String data(String url,String apiName,Model modelMap) {
      GenerationEntity generationEntity = new GenerationEntity();
      GenBeanEntity tableEntity = new GenBeanEntity();
      generationEntity.setEntityName(apiName);

      Map result = new HashMap(3);
      String httpRespond = HttpRequest.post(URL).header("Eo-Secret-Key", Eo_Secret_Key)
            .form(BeanUtil.beanToMap(getEolinkData(url))).execute().body();
      JsonRootBean httpData = JSONUtil.toBean(httpRespond,JsonRootBean.class);
      List<Request_info> requestParams = getRequestParams(httpData);
      List<String> responseParams = getResponseParams(httpData);
      List<GenFieldEntity> requestParamList = requestParams.stream().map(item -> {
          GenFieldEntity fieldEntity = new GenFieldEntity();
          fieldEntity.setName(item.getParam_key());
          fieldEntity.setType(item.getParam_type());
          return fieldEntity;
      }).collect(Collectors.toList());
      List<GenFieldEntity> responseParamList = responseParams.stream().map(item -> {
          Param_list param_list = JSONUtil.toBean(item, Param_list.class);
          GenFieldEntity fieldEntity = new GenFieldEntity();
          fieldEntity.setName(param_list.getParam_key());
          fieldEntity.setType(param_list.getParam_type());
          return fieldEntity;
      }).collect(Collectors.toList());
      tableEntity.setRequestFields(requestParamList);
      tableEntity.setResponseFields(responseParamList);
      generationEntity.setCodePackage(httpData.getApi_info().getBase_info().getApi_url());
      TemplateModel templateModel     = templateService.selectById(251);
      final List<String>  templateFileList = genService.loadTemplateFile(Arrays.asList(templateModel));
        List<String> parse = ParseFactory.getParse(templateModel.getTemplateType()).parse(generationEntity, tableEntity,
                new ArrayList<String>() {
                    {
                        add(templateFileList.get(0));
                    }
        });
      modelMap.addAttribute("code",parse.get(0));
      return  PREFIX + "review_code_api.html";
    }

    private static EolinkData getEolinkData(String url){
        String projectId = url.substring(url.indexOf("inside")+7,url.indexOf("/api/"));
        String spaceId = url.substring(url.indexOf("spaceKey=")+9);
        String apiId = url.substring(url.indexOf("detail")+7,url.indexOf("?spaceKey"));
        Map result = new HashMap(3);
        return new EolinkData(spaceId,projectId,apiId);
    }

    private List<Request_info> getRequestParams(JsonRootBean httpData){
        return httpData.getApi_info().getRequest_info();
    }

    private List<String> getResponseParams(JsonRootBean httpData){
        List<Param_list> param_list = httpData.getApi_info().getResult_info().get(0).getParam_list();
        List<Param_list> collect = param_list.stream().filter(item ->"result".equals(item.getParam_key())).collect(Collectors.toList());
        if(CollUtil.isEmpty(collect)){
            return new ArrayList<>();
        }
        return collect.get(0).getChild_list();
    }


}
