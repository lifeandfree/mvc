package ru.innopolis.service.dto;

/**
 * IndexDto.
 *
 * @author lifeandfree
 */
public class IndexDto {

    private String name;
    private String age;

    public IndexDto(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "IndexDto{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
