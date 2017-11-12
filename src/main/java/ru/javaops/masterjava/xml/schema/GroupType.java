
package ru.javaops.masterjava.xml.schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for groupType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="groupType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="finished"/>
 *     &lt;enumeration value="current"/>
 *     &lt;enumeration value="registering"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "groupType", namespace = "http://javaops.ru")
@XmlEnum
public enum GroupType {

    @XmlEnumValue("finished")
    FINISHED("finished"),
    @XmlEnumValue("current")
    CURRENT("current"),
    @XmlEnumValue("registering")
    REGISTERING("registering");
    private final String value;

    GroupType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GroupType fromValue(String v) {
        for (GroupType c: GroupType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
