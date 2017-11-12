package ru.javaops.masterjava;

import com.google.common.io.Resources;
import ru.javaops.masterjava.xml.schema.*;
import ru.javaops.masterjava.xml.util.JaxbParser;
import ru.javaops.masterjava.xml.util.Schemas;

import javax.xml.bind.JAXBElement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MainXml {
    private static final JaxbParser JAXB_PARSER = new JaxbParser(ObjectFactory.class);

    static {
        JAXB_PARSER.setSchema(Schemas.ofClasspath("payload.xsd"));
    }

    private String projectName;

    public MainXml() {
    }

    public MainXml(String projectName) {
        this.projectName = projectName;
    }

    public void printSortedUserListForProject(String projectName) throws Exception {

        Payload payloadElement = JAXB_PARSER.unmarshal(
                Resources.getResource("payload.xml").openStream());
        Payload payload = payloadElement;

        List<ProjectType> projects = payload.getProjects().getProject();
        List<ProjectType> project = projects.stream().filter(projectType -> projectType.getName().equals(projectName)).collect(Collectors.toList());
        String projectId = project.get(0).getId();

        List<Group> groups = payload.getGroups().getGroup().stream().filter(group -> ((ProjectType)group.getProject()).getName().equals(projectId)).collect(Collectors.toList());

        Payload.Users wholeUsers = payload.getUsers();
        List<User> users = wholeUsers.getUser();
        Set<User> filteredUsers = filterUsers(users, groups);
        for (User u : filteredUsers) {
            System.out.println();
            System.out.println(u.getFullName());
        }
    }

    private Set<User> filterUsers(List<User> users, List<Group> groups) {
        Set<User> newList = new HashSet<>();
        for (User user : users) {
            for (Group group : groups) {
                List<User.Groups.Group> userGroup = user.getGroups().getGroup();
                for (User.Groups.Group gr : userGroup) {
                    if (((Group)gr.getId()).getName().equals(group.getId())) {
                        newList.add(user);
                    }
                }
            }
        }
        return newList;
    }

}
