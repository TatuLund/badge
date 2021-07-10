package org.vaadin.addons.badge;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * This is the Badge component that implements Java API for Lumo Badges.
 * https://vaadin.com/docs/v14/flow/styling/lumo/badges
 *  
 * @author Tatu Lund
 */
@JsModule("@vaadin/vaadin-lumo-styles/badge.js")
@CssImport(value = "./styles/empty.css", include = "lumo-badge")
public class Badge extends Composite<Span> {

	/**
	 * Badge variants  
	 */
    public enum BadgeVariant {
    	/**
    	 * Default variant
    	 */
    	NORMAL(null),
    	/**
    	 * Success type, usually green
    	 */
        SUCCESS("success"),
        /**
         * Error type, usually red
         */
        ERROR("error"),
        /**
         * Contrast type, usually black
         */
        CONTRAST("contrast");

        private String variant;

        BadgeVariant(String variant) {
            this.variant = variant;
        }

        public String getVariant() {
            return variant;
        }
    }
	
    private Span span = new Span();
	private String text = "";
	
    public Badge() {
        span.getElement().getThemeList().add("badge");
    }
    
    public Badge(String text) {
    	this();
        setText(text);
    }

    /**
     * Set the text content of the badge, remove all other content.
     * 
     * @param text String value.
     */
    public void setText(String text) {
    	this.text = text;
    	span.setText(text);
    }

    /**
     * Set the badge variant type. {@link BadgeVariant}
     * 
     * @param variant Badge variant.
     */
    public void setVariant(BadgeVariant variant) {
        for (BadgeVariant v : BadgeVariant.values()) {
            if (v.getVariant() != null)
                getElement().getThemeList().remove(v.getVariant());
        }
        if (variant != BadgeVariant.NORMAL) {
            getElement().getThemeList().add(variant.getVariant());
        }
    }

    /**
     * Set Badge to be primary, more prominent color.
     * 
     * @param primary True for primary.
     */
    public void setPrimary(boolean primary) {
    	if  (primary) {
            getElement().getThemeList().add("primary");
    	} else {
            getElement().getThemeList().remove("primary");
    	}
    }

    /**
     * Set Badge to be pill shaped.
     * 
     * @param pill True for pill.
     */
    public void setPill(boolean pill) {
    	if  (pill) {
            getElement().getThemeList().add("pill");
    	} else {
            getElement().getThemeList().remove("pill");
    	}
    }

    /**
     * Set Badge to be small. Can be combined with primary and pill.
     * 
     * @param small True for small.
     */
    public void setSmall(boolean small) {
    	if  (small) {
            getElement().getThemeList().add("small");
    	} else {
            getElement().getThemeList().remove("small");
    	}
    }

    /**
     * Set icon to be wrapped before the text.
     * 
     * @param icon Icon component.
     */
    public void setIcon(Icon icon) {
    	setIcon(icon,true);
    }

    
    /**
     * Set icon to be wrapped before or after the text.
     * 
     * @param icon Icon component.
     * @param first True for icon to appear before text.
     */
    public void setIcon(Icon icon, boolean first) {
    	getElement().removeAllChildren();
    	if (first) {
        	span.add(icon);
        	span.add(new Span(text));
    	} else {
        	span.add(new Span(text));
        	span.add(icon);    		
    	}
    }

    @Override
	protected Span initContent() {
    	return span;
    }
}
