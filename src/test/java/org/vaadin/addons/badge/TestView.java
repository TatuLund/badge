package org.vaadin.addons.badge;

import org.vaadin.addons.badge.Badge;
import org.vaadin.addons.badge.Badge.BadgeVariant;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.IronIcon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * Test View for our {@link Badge} add-on class. This class and others in the
 * test folder will not be included in the final JAR.
 */
@Route("")
public class TestView extends VerticalLayout {

    public TestView() {
    	add(createBadges("",false));
    	add(createBadges("primary",false));
    	add(createBadges("pill",false));
    	add(createBadges("small",false));
    	add(createBadges("primarypill",false));
    	add(createBadges("",true));
    	add(createBadges("primary",true));
    	add(createBadges("pill",true));
    	add(createBadges("small",true));
    	add(createBadges("primarypill",true));
    }

    public HorizontalLayout createBadges(String type, boolean icon) {
    	HorizontalLayout layout = new HorizontalLayout();
    	for (BadgeVariant variant : BadgeVariant.values()) {
    		Badge badge = new Badge("text");
    		badge.setVariant(variant);
    		if (icon) {
				badge.setIcon(new Icon("lumo","clock"));    			
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
