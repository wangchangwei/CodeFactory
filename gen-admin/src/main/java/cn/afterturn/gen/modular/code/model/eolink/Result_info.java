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
public class Result_info {

    private long response_id;
    private String response_code;
    private String response_name;
    private String response_type;
    private String param_json_type;
    private List<Param_list> param_list;
    private String raw;
    private String binary;
    private int is_default;
    public void setResponse_id(long response_id) {
         this.response_id = response_id;
     }
     public long getResponse_id() {
         return response_id;
     }

    public void setResponse_code(String response_code) {
         this.response_code = response_code;
     }
     public String getResponse_code() {
         return response_code;
     }

    public void setResponse_name(String response_name) {
         this.response_name = response_name;
     }
     public String getResponse_name() {
         return response_name;
     }

    public void setResponse_type(String response_type) {
         this.response_type = response_type;
     }
     public String getResponse_type() {
         return response_type;
     }

    public void setParam_json_type(String param_json_type) {
         this.param_json_type = param_json_type;
     }
     public String getParam_json_type() {
         return param_json_type;
     }

    public void setParam_list(List<Param_list> param_list) {
         this.param_list = param_list;
     }
     public List<Param_list> getParam_list() {
         return param_list;
     }

    public void setRaw(String raw) {
         this.raw = raw;
     }
     public String getRaw() {
         return raw;
     }

    public void setBinary(String binary) {
         this.binary = binary;
     }
     public String getBinary() {
         return binary;
     }

    public void setIs_default(int is_default) {
         this.is_default = is_default;
     }
     public int getIs_default() {
         return is_default;
     }

}