/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kedar
 */
public class MenuBean {
String node;
String parent;
int seq;
String pos;
String role;
String url;
String visibility;
String linkState;

    public MenuBean(String node, String parent, int seq, String pos, String role, String url, String visibility, String linkState) {
        this.node = node;
        this.parent = parent;
        this.seq = seq;
        this.pos = pos;
        this.role = role;
        this.url = url;
        this.visibility = visibility;
        this.linkState = linkState;
    }
   
    public String getLinkState() {
        return linkState;
    }

    public void setLinkState(String linkState) {
        this.linkState = linkState;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }


    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public MenuBean(String node, String parent, int seq, String pos) {
        this.node = node;
        this.parent = parent;
        this.seq = seq;
        this.pos = pos;
    }


    MenuBean() {
        
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

}
