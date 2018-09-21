
package com.testjackson.googleimage;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "titleNoFormatting",
    "tbUrl",
    "originalContextUrl",
    "width",
    "unescapedUrl",
    "url",
    "visibleUrl",
    "content",
    "GsearchResultClass",
    "tbWidth",
    "title",
    "height",
    "imageId",
    "contentNoFormatting",
    "tbHeight"
})
public class Result {

    @JsonProperty("titleNoFormatting")
    private String titleNoFormatting;
    @JsonProperty("tbUrl")
    private String tbUrl;
    @JsonProperty("originalContextUrl")
    private String originalContextUrl;
    @JsonProperty("width")
    private String width;
    @JsonProperty("unescapedUrl")
    private String unescapedUrl;
    @JsonProperty("url")
    private String url;
    @JsonProperty("visibleUrl")
    private String visibleUrl;
    @JsonProperty("content")
    private String content;
    @JsonProperty("GsearchResultClass")
    private String GsearchResultClass;
    @JsonProperty("tbWidth")
    private String tbWidth;
    @JsonProperty("title")
    private String title;
    @JsonProperty("height")
    private String height;
    @JsonProperty("imageId")
    private String imageId;
    @JsonProperty("contentNoFormatting")
    private String contentNoFormatting;
    @JsonProperty("tbHeight")
    private String tbHeight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The titleNoFormatting
     */
    @JsonProperty("titleNoFormatting")
    public String getTitleNoFormatting() {
        return titleNoFormatting;
    }

    /**
     * 
     * @param titleNoFormatting
     *     The titleNoFormatting
     */
    @JsonProperty("titleNoFormatting")
    public void setTitleNoFormatting(String titleNoFormatting) {
        this.titleNoFormatting = titleNoFormatting;
    }

    /**
     * 
     * @return
     *     The tbUrl
     */
    @JsonProperty("tbUrl")
    public String getTbUrl() {
        return tbUrl;
    }

    /**
     * 
     * @param tbUrl
     *     The tbUrl
     */
    @JsonProperty("tbUrl")
    public void setTbUrl(String tbUrl) {
        this.tbUrl = tbUrl;
    }

    /**
     * 
     * @return
     *     The originalContextUrl
     */
    @JsonProperty("originalContextUrl")
    public String getOriginalContextUrl() {
        return originalContextUrl;
    }

    /**
     * 
     * @param originalContextUrl
     *     The originalContextUrl
     */
    @JsonProperty("originalContextUrl")
    public void setOriginalContextUrl(String originalContextUrl) {
        this.originalContextUrl = originalContextUrl;
    }

    /**
     * 
     * @return
     *     The width
     */
    @JsonProperty("width")
    public String getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    @JsonProperty("width")
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * 
     * @return
     *     The unescapedUrl
     */
    @JsonProperty("unescapedUrl")
    public String getUnescapedUrl() {
        return unescapedUrl;
    }

    /**
     * 
     * @param unescapedUrl
     *     The unescapedUrl
     */
    @JsonProperty("unescapedUrl")
    public void setUnescapedUrl(String unescapedUrl) {
        this.unescapedUrl = unescapedUrl;
    }

    /**
     * 
     * @return
     *     The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The visibleUrl
     */
    @JsonProperty("visibleUrl")
    public String getVisibleUrl() {
        return visibleUrl;
    }

    /**
     * 
     * @param visibleUrl
     *     The visibleUrl
     */
    @JsonProperty("visibleUrl")
    public void setVisibleUrl(String visibleUrl) {
        this.visibleUrl = visibleUrl;
    }

    /**
     * 
     * @return
     *     The content
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * @return
     *     The GsearchResultClass
     */
    @JsonProperty("GsearchResultClass")
    public String getGsearchResultClass() {
        return GsearchResultClass;
    }

    /**
     * 
     * @param GsearchResultClass
     *     The GsearchResultClass
     */
    @JsonProperty("GsearchResultClass")
    public void setGsearchResultClass(String GsearchResultClass) {
        this.GsearchResultClass = GsearchResultClass;
    }

    /**
     * 
     * @return
     *     The tbWidth
     */
    @JsonProperty("tbWidth")
    public String getTbWidth() {
        return tbWidth;
    }

    /**
     * 
     * @param tbWidth
     *     The tbWidth
     */
    @JsonProperty("tbWidth")
    public void setTbWidth(String tbWidth) {
        this.tbWidth = tbWidth;
    }

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The height
     */
    @JsonProperty("height")
    public String getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The imageId
     */
    @JsonProperty("imageId")
    public String getImageId() {
        return imageId;
    }

    /**
     * 
     * @param imageId
     *     The imageId
     */
    @JsonProperty("imageId")
    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    /**
     * 
     * @return
     *     The contentNoFormatting
     */
    @JsonProperty("contentNoFormatting")
    public String getContentNoFormatting() {
        return contentNoFormatting;
    }

    /**
     * 
     * @param contentNoFormatting
     *     The contentNoFormatting
     */
    @JsonProperty("contentNoFormatting")
    public void setContentNoFormatting(String contentNoFormatting) {
        this.contentNoFormatting = contentNoFormatting;
    }

    /**
     * 
     * @return
     *     The tbHeight
     */
    @JsonProperty("tbHeight")
    public String getTbHeight() {
        return tbHeight;
    }

    /**
     * 
     * @param tbHeight
     *     The tbHeight
     */
    @JsonProperty("tbHeight")
    public void setTbHeight(String tbHeight) {
        this.tbHeight = tbHeight;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
