/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_The_Code_Book;

class SharedCodeList {
    private int id;
    private String sid;
    private String title;
    private String content;
    private String update;
    private String created;
    
    public SharedCodeList(int id, String title, String content){
    this.id = id;
    this.title = title;
    this.content = content;
    }

    SharedCodeList(String id, String title, String content,String update,String created) {
    this.sid = id;
    this.title = title;
    this.content = content; 
    this.created = created;
    this.update = update;
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
