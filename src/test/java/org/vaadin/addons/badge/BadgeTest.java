package org.vaadin.addons.badge;

import org.junit.Assert;
import org.junit.Test;
import org.vaadin.addons.badge.Badge.BadgeVariant;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.dom.ThemeList;

public class BadgeTest {

    @Test
    public void setVariant_setPill() {
        Badge badge = new Badge();
        badge.setVariant(BadgeVariant.ERROR);
        ThemeList themeNames = badge.getThemeNames();
        Assert.assertFalse(themeNames.contains("pill"));
        int size = themeNames.size();
        badge.setPill(true);
        themeNames = badge.getThemeNames();
        Assert.assertTrue(themeNames.contains("pill"));
        Assert.assertEquals(size + 1, themeNames.size());
        badge.setPill(false);
        themeNames = badge.getThemeNames();
        Assert.assertFalse(themeNames.contains("pill"));
    }

    @Test
    public void setVariant_setPrimary() {
        Badge badge = new Badge();
        badge.setVariant(BadgeVariant.ERROR);
        ThemeList themeNames = badge.getThemeNames();
        Assert.assertFalse(themeNames.contains("primary"));
        int size = themeNames.size();
        badge.setPrimary(true);
        themeNames = badge.getThemeNames();
        Assert.assertTrue(themeNames.contains("primary"));
        Assert.assertEquals(size + 1, themeNames.size());
        badge.setPrimary(false);
        themeNames = badge.getThemeNames();
        Assert.assertFalse(themeNames.contains("primary"));
    }

    @Test
    public void setVariant_setSmall() {
        Badge badge = new Badge();
        badge.setVariant(BadgeVariant.ERROR);
        ThemeList themeNames = badge.getThemeNames();
        Assert.assertFalse(themeNames.contains("small"));
        int size = themeNames.size();
        badge.setSmall(true);
        themeNames = badge.getThemeNames();
        Assert.assertTrue(themeNames.contains("small"));
        Assert.assertEquals(size + 1, themeNames.size());
        badge.setSmall(false);
        themeNames = badge.getThemeNames();
        Assert.assertFalse(themeNames.contains("small"));
    }

    @Test
    public void setVariant_setSmall_setPrimary() {
        Badge badge = new Badge();
        badge.setVariant(BadgeVariant.ERROR);
        ThemeList themeNames = badge.getThemeNames();
        int size = themeNames.size();
        badge.setSmall(true);
        badge.setPrimary(true);
        themeNames = badge.getThemeNames();
        Assert.assertTrue(themeNames.contains("small"));
        Assert.assertTrue(themeNames.contains("primary"));
        Assert.assertEquals(size + 2, themeNames.size());
        badge.setPrimary(false);
        themeNames = badge.getThemeNames();
        Assert.assertFalse(themeNames.contains("primary"));
        Assert.assertTrue(themeNames.contains("small"));
    }

    @Test
    public void setVariant_setSmall_setPill() {
        Badge badge = new Badge();
        badge.setVariant(BadgeVariant.ERROR);
        ThemeList themeNames = badge.getThemeNames();
        int size = themeNames.size();
        badge.setSmall(true);
        badge.setPill(true);
        themeNames = badge.getThemeNames();
        Assert.assertTrue(themeNames.contains("small"));
        Assert.assertTrue(themeNames.contains("pill"));
        Assert.assertEquals(size + 2, themeNames.size());
        badge.setPill(false);
        themeNames = badge.getThemeNames();
        Assert.assertFalse(themeNames.contains("pill"));
        Assert.assertTrue(themeNames.contains("small"));
    }

    @Test
    public void setVariant_themeNamesContainsOnlyTheSetThemeVariant() {
        Badge badge = new Badge();
        badge.setSmall(true);
        badge.setVariant(BadgeVariant.ERROR);

        ThemeList themeNames = badge.getThemeNames();
        Assert.assertTrue(themeNames.contains(BadgeVariant.ERROR.getVariant()));
        Assert.assertTrue(themeNames.contains("small"));

        badge.setVariant(BadgeVariant.SUCCESS);
        themeNames = badge.getThemeNames();
        Assert.assertTrue(
                themeNames.contains(BadgeVariant.SUCCESS.getVariant()));
        Assert.assertFalse(
                themeNames.contains(BadgeVariant.ERROR.getVariant()));
        Assert.assertTrue(themeNames.contains("small"));

        badge.setVariant(BadgeVariant.NORMAL);
        themeNames = badge.getThemeNames();
        Assert.assertFalse(
                themeNames.contains(BadgeVariant.SUCCESS.getVariant()));
        Assert.assertTrue(themeNames.contains("small"));
    }

    @Test
    public void setText() {
        Badge badge = new Badge();
        badge.setText("Badge");
        Assert.assertEquals(1, badge.getElement().getChildren().count());
        Assert.assertEquals("Badge", badge.getElement().getChild(0).getText());
        badge.setText("Text");
        Assert.assertEquals(1, badge.getElement().getChildren().count());
        Assert.assertEquals("Text", badge.getElement().getChild(0).getText());
    }

    @Test
    public void setHtml() {
        Badge badge = new Badge();
        badge.setHtml("<span><b>Html</b></span>");
        Assert.assertEquals(1, badge.getElement().getChildren().count());
        Assert.assertEquals("<span slot=\"content\"><b>Html</b></span>",
                badge.getElement().getChild(0).getOuterHTML());
        badge.setHtml("<span><i>Html</i></span>");
        Assert.assertEquals(1, badge.getElement().getChildren().count());
        Assert.assertEquals("<span slot=\"content\"><i>Html</i></span>",
                badge.getElement().getChild(0).getOuterHTML());
    }

    @Test
    public void setIcon_before() {
        Badge badge = new Badge("Badge");
        badge.setIcon(VaadinIcon.VAADIN_H.create());
        Assert.assertEquals(2, badge.getElement().getChildren().count());
        Assert.assertEquals("Badge", badge.getElement().getChild(1).getText());
        Assert.assertEquals(
                "<vaadin-icon icon=\"vaadin:vaadin-h\" slot=\"content\"></vaadin-icon>",
                badge.getElement().getChild(0).getOuterHTML());
        badge.setIcon(VaadinIcon.VAADIN_V.create());
        Assert.assertEquals(2, badge.getElement().getChildren().count());
        Assert.assertEquals(
                "<vaadin-icon icon=\"vaadin:vaadin-v\" slot=\"content\"></vaadin-icon>",
                badge.getElement().getChild(0).getOuterHTML());
        badge.setText("Text");
        Assert.assertEquals(1, badge.getElement().getChildren().count());
        Assert.assertEquals("Text", badge.getElement().getChild(0).getText());
    }

    @Test
    public void setIcon_after_before() {
        Badge badge = new Badge("Badge");
        badge.setIcon(VaadinIcon.VAADIN_H.create(), false);
        Assert.assertEquals(2, badge.getElement().getChildren().count());
        Assert.assertEquals("Badge", badge.getElement().getChild(0).getText());
        Assert.assertEquals(
                "<vaadin-icon icon=\"vaadin:vaadin-h\" slot=\"content\"></vaadin-icon>",
                badge.getElement().getChild(1).getOuterHTML());
        badge.setIcon(VaadinIcon.VAADIN_V.create());
        Assert.assertEquals(2, badge.getElement().getChildren().count());
        Assert.assertEquals("Badge", badge.getElement().getChild(1).getText());
        Assert.assertEquals(
                "<vaadin-icon icon=\"vaadin:vaadin-v\" slot=\"content\"></vaadin-icon>",
                badge.getElement().getChild(0).getOuterHTML());
        badge.setText("Text");
        Assert.assertEquals(1, badge.getElement().getChildren().count());
        Assert.assertEquals("Text", badge.getElement().getChild(0).getText());
    }

    @Test
    public void setIcon_html_after_before() {
        Badge badge = new Badge();
        badge.setHtml("<span>Badge</span");
        badge.setIcon(VaadinIcon.VAADIN_H.create(), false);
        Assert.assertEquals(2, badge.getElement().getChildren().count());
        Assert.assertEquals("<span slot=\"content\">Badge</span>",
                badge.getElement().getChild(0).getOuterHTML());
        Assert.assertEquals(
                "<vaadin-icon icon=\"vaadin:vaadin-h\" slot=\"content\"></vaadin-icon>",
                badge.getElement().getChild(1).getOuterHTML());
        badge.setIcon(VaadinIcon.VAADIN_V.create());
        Assert.assertEquals(2, badge.getElement().getChildren().count());
        Assert.assertEquals("<span slot=\"content\">Badge</span>",
                badge.getElement().getChild(1).getOuterHTML());
        Assert.assertEquals(
                "<vaadin-icon icon=\"vaadin:vaadin-v\" slot=\"content\"></vaadin-icon>",
                badge.getElement().getChild(0).getOuterHTML());
        badge.setHtml("<span>Text</span>");
        Assert.assertEquals(2, badge.getElement().getChildren().count());
        Assert.assertEquals("<span slot=\"content\">Text</span>",
                badge.getElement().getChild(0).getOuterHTML());
        Assert.assertEquals(
                "<vaadin-icon icon=\"vaadin:vaadin-v\" slot=\"content\"></vaadin-icon>",
                badge.getElement().getChild(1).getOuterHTML());
    }

    @Test
    public void padding() {
        Badge badge = new Badge();
        Assert.assertFalse(badge.getElement().getThemeList().contains("badge"));
        badge.setPadding(true);
        Assert.assertTrue(badge.getElement().getThemeList().contains("badge"));
    }
}
