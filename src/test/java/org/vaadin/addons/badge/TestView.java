package org.vaadin.addons.badge;

import org.vaadin.addons.badge.Badge.BadgeVariant;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.router.Route;

/**
 * Test View for our {@link Badge} add-on class. This class and others in the
 * test folder will not be included in the final JAR.
 */
@Route("")
@CssImport("./styles.css")
public class TestView extends VerticalLayout implements AppShellConfigurator {

    public TestView() {
        add(createBadges("", false, null));
        add(createBadges("primary", false, null));
        add(createBadges("pill", false, null));
        add(createBadges("small", false, null));
        add(createBadges("primarypill", false, null));

        add(createBadges("", true, null));
        add(createBadges("primary", true, null));
        add(createBadges("pill", true, null));
        add(createBadges("small", true, null));
        add(createBadges("primarypill", true, null));

        add(createBadges("", false, "bold"));
        add(createBadges("primary", false, "bold"));
        add(createBadges("pill", false, "bold"));
        add(createBadges("primarypill", true, "bold"));
    }

    public HorizontalLayout createBadges(String type, boolean icon,
            String html) {
        HorizontalLayout layout = new HorizontalLayout();
        for (BadgeVariant variant : BadgeVariant.values()) {
            Badge badge = new Badge();
            if (html != null) {
                badge.setHtml(
                        "<span style='font-weight: 700;'>" + html + "</span>");
            } else {
                badge.setText("text");
            }
            badge.setVariant(variant);
            if (icon) {
                badge.setIcon(new Icon("lumo", "clock"));
            }
            switch (type) {
            case "": {
                break;
            }
            case "primary": {
                badge.setPrimary(true);
                break;
            }
            case "pill": {
                badge.setPill(true);
                break;
            }
            case "small": {
                badge.setSmall(true);
                break;
            }
            case "primarypill": {
                badge.setPrimary(true);
                badge.setPill(true);
                break;
            }
            }
            layout.add(badge);
        }
        return layout;
    }
}
