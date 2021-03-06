package GUI_The_Code_Book;

public class CodeList {
    private String id;
    private String language;
    private String title;
    private String content;
    private String type;
    
    public CodeList(String id,String title,String content,String type){
        this.setId(id);
        //this.setLanguage(language);
        this.setTitle(title);
        this.setContent(content);
        this.setType(type);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the language
     */
    /*public String getLanguage() {
        return language;
    }*/

    /**
     * @param language the language to set
     */
   /* public void setLanguage(String language) {
        this.language = language;
    }
*/
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
    
}
