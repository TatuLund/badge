package org.vaadin.addons.badge;

import org.junit.Assert;
import org.junit.Test;
import org.vaadin.addons.badge.Badge.BadgeVariant;

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
        Assert.assertEquals(size+1,themeNames.size());
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
        Assert.assertEquals(size+1,themeNames.size());
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
        Assert.assertEquals(size+1,themeNames.size());
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
        Assert.assertEquals(size+2,themeNames.size());
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
        Assert.assertEquals(size+2,themeNames.size());
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

}
