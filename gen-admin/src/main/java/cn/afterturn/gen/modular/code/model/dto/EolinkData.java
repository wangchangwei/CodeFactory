package cn.afterturn.gen.modular.code.model.dto;


/**
 * @author 王长伟
 */
public class EolinkData {
    public EolinkData(String space_id, String project_id, String api_id) {
        this.space_id = space_id;
        this.project_id = project_id;
        this.api_id = api_id;
    }

    public EolinkData() {

    }
    private String space_id;

    private String project_id;

    private String api_id;

    public String getSpace_id() {
        return space_id;
    }

    public void setSpace_id(String space_id) {
        this.space_id = space_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getApi_id() {
        return api_id;
    }

    public void setApi_id(String api_id) {
        this.api_id = api_id;
    }
}
