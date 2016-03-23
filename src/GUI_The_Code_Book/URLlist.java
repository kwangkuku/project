/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_The_Code_Book;

public class URLlist {
    
    private int view_content;
    private int answer_count;
    private String title;
    private String link;
    
    public URLlist(int view_content, int answer_count,String title,String link){
        this.view_content = view_content;
        this.answer_count = answer_count;
        this.title = title;
        this.link = link;
    }

    /**
     * @return the view_content
     */
    public int getView_content() {
        return view_content;
    }

    /**
     * @param view_content the view_content to set
     */
    public void setView_content(int view_content) {
        this.view_content = view_content;
    }

    /**
     * @return the answer_count
     */
    public int getAnswer_count() {
        return answer_count;
    }

    /**
     * @param answer_count the answer_count to set
     */
    public void setAnswer_count(int answer_count) {
        this.answer_count = answer_count;
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
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }
    
    
    
}
