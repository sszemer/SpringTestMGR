package POJO;

import org.springframework.data.annotation.Id;

public class TestPOJO {

    @Id
    private String id;
    private String name;
    private String result;
    private String failure;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }

    public TestPOJO(String name, String id, String result, String failure){
        this.name=name;
        this.id=id;
        this.result=result;
        this.failure = failure;
    }

    public TestPOJO() {
    }
}
