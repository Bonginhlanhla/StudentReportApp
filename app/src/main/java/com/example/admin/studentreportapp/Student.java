package com.example.admin.studentreportapp;

/**
 * Created by Admin on 8/21/2017.
 */

public class Student {

        private long empId;
        private String firstname;
        private String lastname;
        private int subOne;
        private int subTwo;
        private int subThree;
        private int subFour;
        private int subFive;
        private String comments;



        public Student(long empId, String firstname, String lastname, int subOne, int subTwo, int subThree, int subFour, int subFive, String comments){
            this.empId = empId;
            this.firstname = firstname;
            this.lastname = lastname;
            this.subOne = subOne;
            this.subTwo = subTwo;
            this.subThree = subThree;
            this.subThree = subFour;
            this.subThree = subFive;

        }

        public Student(){

        }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public long getEmpId() {
            return empId;
        }

        public void setEmpId(long empId) {
            this.empId = empId;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

    public int getSubOne() {
        return subOne;
    }

    public void setSubOne(int subOne) {
        this.subOne = subOne;
    }

    public int getSubTwo() {
        return subTwo;
    }

    public void setSubTwo(int subTwo) {
        this.subTwo = subTwo;
    }

    public int getSubThree() {
        return subThree;
    }

    public void setSubThree(int subThree) {
        this.subThree = subThree;
    }

    public int getSubFour() {
        return subFour;
    }

    public void setSubFour(int subFour) {
        this.subFour = subFour;
    }

    public int getSubFive() {
        return subFive;
    }

    public void setSubFive(int subFive) {
        this.subFive = subFive;
    }

    public String toString(){
            return "Stud id:"           +getEmpId()+ "\n" +
                    "Name:"             +getFirstname() + " " + getLastname() + "\n" +
                    "English:"          +getSubOne() + "\n" +
                    "Afrikaans:"        +getSubThree() + "\n" +
                    "Mathametics:"      +getSubThree() + "\n" +
                    "Life Science:"     +getSubFour() + "\n" +
                    "Physical Science:" +getSubFive() + "\n" +
                    "Comments:"         +getComments();


        }
}
