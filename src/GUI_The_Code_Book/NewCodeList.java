/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_The_Code_Book;

/**
 *
 * @author Administrator
 */
class NewCodeList {
     private int id;
    private String title;
    private String content;
    private String type;

    public NewCodeList(int id,String title,String content,String type){
        this.setId(id);
        this.setType(type);
        this.setTitle(title);
        this.setContent(content);
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the language
     */
    public String getType() {
        return type;
    }

    /**
     * @param language the language to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the title
     */
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
    
   

}
