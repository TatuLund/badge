package org.vaadin.addons.badge;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.vaadin.flow.component.html.testbench.DivElement;
import com.vaadin.flow.component.html.testbench.SpanElement;
import com.vaadin.testbench.TestBenchElement;
import com.vaadin.testbench.screenshot.ImageFileUtil;

public class BadgeIT extends AbstractViewTest {

    @Override
    public void setup() throws Exception {
        super.setup();

        // Hide dev mode gizmo, it would interfere screenshot tests
        $("vaadin-devmode-gizmo").first().setProperty("hidden", true);
    }

    @Test
    public void themePropagationWorksEtc() {
        BadgeElement badge = $(BadgeElement.class).first();
        SpanElement internalSpan = badge.$(SpanElement.class).first();
        Assert.assertEquals("text",internalSpan.getText());
        Assert.assertTrue(internalSpan.getAttribute("theme").contains("badge"));
        badge = $(BadgeElement.class).all().get(1);
        internalSpan = badge.$(SpanElement.class).first();
        Assert.assertTrue(internalSpan.getAttribute("theme").contains("success"));
        badge = $(BadgeElement.class).all().get(2);
        internalSpan = badge.$(SpanElement.class).first();
        Assert.assertTrue(internalSpan.getAttribute("theme").contains("error"));
        badge = $(BadgeElement.class).all().get(3);
        internalSpan = badge.$(SpanElement.class).first();
        Assert.assertTrue(internalSpan.getAttribute("theme").contains("contrast"));
        badge = $(BadgeElement.class).all().get(4);
        internalSpan = badge.$(SpanElement.class).first();
        Assert.assertTrue(internalSpan.getAttribute("theme").contains("primary"));
        badge = $(BadgeElement.class).all().get(8);
        internalSpan = badge.$(SpanElement.class).first();
        Assert.assertTrue(internalSpan.getAttribute("theme").contains("pill"));
        badge = $(BadgeElement.class).all().get(12);
        internalSpan = badge.$(SpanElement.class).first();
        Assert.assertTrue(internalSpan.getAttribute("theme").contains("small"));
        badge = $(BadgeElement.class).all().get(20);
        TestBenchElement icon = badge.$("vaadin-icon").first();
        Assert.assertEquals("lumo:clock",icon.getAttribute("icon"));
        badge = $(BadgeElement.class).all().get(40);
        DivElement htmlDiv = badge.$(DivElement.class).first();
        Assert.assertEquals("bold",htmlDiv.getText());
        Assert.assertEquals("700",htmlDiv.getCssValue("font-weight"));
    }

    @Test
    public void visualScreenShotTest() throws IOException {
        Assert.assertTrue(testBench().compareScreen(
                ImageFileUtil.getReferenceScreenshotFile("badges.png")));        
    }
}
