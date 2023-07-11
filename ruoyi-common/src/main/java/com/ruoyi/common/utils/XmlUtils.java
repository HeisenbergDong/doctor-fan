package com.ruoyi.common.utils;

import com.thoughtworks.xstream.XStream;
import me.chanjar.weixin.common.util.xml.XStreamInitializer;

public class XmlUtils {

    public static String toXML(Object object) {
        XStream xstream = XStreamInitializer.getInstance();
        xstream.processAnnotations(object.getClass());
        return xstream.toXML(object);
    }
}
