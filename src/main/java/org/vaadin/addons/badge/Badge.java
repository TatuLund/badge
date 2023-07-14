package org.vaadin.addons.badge;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasTheme;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.shared.HasTooltip;

/**
 * This is the Badge component that implements Java API for Lumo Badges.
 * https://vaadin.com/docs/v14/flow/styling/lumo/badges
 * 
 * @author Tatu Lund
 */
@JsModule("@vaadin/vaadin-lumo-styles/badge.js")
@JsModule("./badge.ts")
@Tag("tatus-badge")
public class Badge extends Component implements HasTheme, HasTooltip {

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
         * Error type, usually orange, (requires Vaadin 24.1+)
         */
        WARNING("warning"),
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

    private String text = "";
    private Icon icon;
    private boolean first;
    private String html;

    public Badge() {
    }

    public Badge(String text) {
        this();
        setText(text);
    }

    /**
     * Set the text content of the badge, remove all other content.
     * 
     * @param text
     *            String value.
     */
    public void setText(String text) {
        this.text = text;
        getElement().removeAllChildren();
        add(new Span(text));
    }

    /**
     * Set the badge variant type. {@link BadgeVariant}
     * 
     * @param variant
     *            Badge variant.
     */
    public void setVariant(BadgeVariant variant) {
        for (BadgeVariant v : BadgeVariant.values()) {
            if (v.getVariant() != null)
                removeThemeName(v.getVariant());
        }
        if (variant != BadgeVariant.NORMAL) {
            addThemeName(variant.getVariant());
        }
    }

    /**
     * Set Badge to be primary, more prominent color.
     * 
     * @param primary
     *            True for primary.
     */
    public void setPrimary(boolean primary) {
        if (primary) {
            addThemeName("primary");
        } else {
            removeThemeName("primary");
        }
    }

    /**
     * Set Badge to be pill shaped.
     * 
     * @param pill
     *            True for pill.
     */
    public void setPill(boolean pill) {
        if (pill) {
            addThemeName("pill");
        } else {
            removeThemeName("pill");
        }
    }

    /**
     * Set Badge to be small. Can be combined with primary and pill.
     * 
     * @param small
     *            True for small.
     */
    public void setSmall(boolean small) {
        if (small) {
            addThemeName("small");
        } else {
            removeThemeName("small");
        }
    }

    /**
     * Set icon to be wrapped before the text.
     * 
     * @param icon
     *            Icon component.
     */
    public void setIcon(Icon icon) {
        setIcon(icon, true);
    }

    /**
     * Set icon to be wrapped before or after the text.
     * 
     * @param icon
     *            Icon component.
     * @param first
     *            True for icon to appear before text.
     */
    public void setIcon(Icon icon, boolean first) {
        getElement().removeAllChildren();
        this.icon = icon;
        this.first = first;
        if (first) {
            add(icon);
            if (html != null) {
                add(new Html(html));
            } else {
                add(new Span(text));
            }
        } else {
            if (html != null) {
                add(new Html(html));
            } else {
                add(new Span(text));
            }
            add(icon);
        }
    }

    /**
     * Set the text content of the badge as html, remove previous text or html,
     * but preserve icon.
     * <p>
     * Note: Use carefully, html is not sanitized.
     * 
     * @param html
     *            String value.
     */
    public void setHtml(String html) {
        this.html = html;
        getElement().removeAllChildren();
        if (first && icon != null) {
            add(icon);
        }
        add(new Html(html));
        if (icon != null) {
            add(icon);
        }
    }

    /**
     * If true, add paler padding in the badge
     * 
     * Note: Has effect only in Vaadin 24.1+
     * 
     * @param padding
     *            boolean
     */
    public void setPadding(boolean padding) {
        if (padding) {
            addThemeName("badge");
        } else {
            removeThemeName("badge");
        }
    }

    void add(Component comp) {
        comp.getElement().setAttribute("slot", "content");
        getElement().appendChild(comp.getElement());
    }
}
