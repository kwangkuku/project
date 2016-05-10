/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_The_Code_Book;

class SharedCodeList {
    private int id_code;
   
    private String title;
    private String content;
    private String  description;
    private String type;
    private Double evaluation;
    private int viewcounter;

    
    public SharedCodeList(int id_code, String title, String content,String description,String type,Double evaluation,int viewcounter){
    this.id_code = id_code;
    this.title = title;
    this.content = content;
    this.description = description;
    this.type = type;
    this.evaluation=evaluation;
    this.viewcounter = viewcounter;
    }

    

    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the id_code
     */
    public int getId_code() {
        return id_code;
    }

    /**
     * @param id_code the id_code to set
     */
    public void setId_code(int id_code) {
        this.id_code = id_code;
    }

    /**
     * @return the Evaluation
     */
    public Double getEvaluation() {
        return evaluation;
    }

    /**
     * @param Evaluation the Evaluation to set
     */
    public void setEvaluation(Double evaluation) {
        this.evaluation = evaluation;
    }

    /**
     * @return the viewcounter
     */
    public int getViewcounter() {
        return viewcounter;
    }

    /**
     * @param viewcounter the viewcounter to set
     */
    public void setViewcounter(int viewcounter) {
        this.viewcounter = viewcounter;
    }
    
}
