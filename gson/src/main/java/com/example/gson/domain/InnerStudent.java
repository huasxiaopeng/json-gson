package com.example.gson.domain;

/**
 * @Description TODO
 * @Author lktbz
 * @Date 2021/07/20
 */
public class InnerStudent {
    private int rollNo;
    private Name name;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

   public class Name {
        public String firstName;
        public String lastName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Name{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "InnerStudent{" +
                "rollNo=" + rollNo +
                ", name=" + name +
                '}';
    }
}
