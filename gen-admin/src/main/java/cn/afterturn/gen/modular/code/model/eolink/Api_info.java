/**
  * Copyright 2023 json.cn 
  */
package cn.afterturn.gen.modular.code.model.eolink;
import java.util.List;

/**
 * Auto-generated: 2023-04-17 18:6:47
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Api_info {

    private Base_info base_info;
    private String api_type;
    private List<String> header_info;
    private List<Request_info> request_info;
    private List<Result_info> result_info;
    private List<String> url_param;
    private List<String> restful_param;
    private List<String> response_header;
    private String create_username;
    public void setBase_info(Base_info base_info) {
         this.base_info = base_info;
     }
     public Base_info getBase_info() {
         return base_info;
     }

    public void setApi_type(String api_type) {
         this.api_type = api_type;
     }
     public String getApi_type() {
         return api_type;
     }

    public void setHeader_info(List<String> header_info) {
         this.header_info = header_info;
     }
     public List<String> getHeader_info() {
         return header_info;
     }

    public void setRequest_info(List<Request_info> request_info) {
         this.request_info = request_info;
     }
     public List<Request_info> getRequest_info() {
         return request_info;
     }

    public void setResult_info(List<Result_info> result_info) {
         this.result_info = result_info;
     }
     public List<Result_info> getResult_info() {
         return result_info;
     }

    public void setUrl_param(List<String> url_param) {
         this.url_param = url_param;
     }
     public List<String> getUrl_param() {
         return url_param;
     }

    public void setRestful_param(List<String> restful_param) {
         this.restful_param = restful_param;
     }
     public List<String> getRestful_param() {
         return restful_param;
     }

    public void setResponse_header(List<String> response_header) {
         this.response_header = response_header;
     }
     public List<String> getResponse_header() {
         return response_header;
     }

    public void setCreate_username(String create_username) {
         this.create_username = create_username;
     }
     public String getCreate_username() {
         return create_username;
     }

}