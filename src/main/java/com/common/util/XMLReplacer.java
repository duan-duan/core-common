package com.common.util;

import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;

public class XMLReplacer extends XmlFriendlyReplacer {
		public String escapeName(String name) {
			return name;
		}
        public String unescapeName(String name) {
        	return name;
        }


}