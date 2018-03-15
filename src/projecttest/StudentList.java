/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttest;

/**
 *
 * @author Humayun
 */
public class StudentList extends RecordList {
    public StudentList(){
    super();
    }
    public StudentList(int sizeIn) {
super(sizeIn);
}

public Student getStudent(int positionIn) {
if (positionIn<1 || positionIn>getTotal()) {
return null;
} else {

return (Student) getItem(positionIn);
}

}

public Student search(int roomIn) {
for (int i = 1; i <= getTotal(); i++) {
if(getStudent(i).getRoom()==roomIn ) {
return getStudent(i);
}
}
return null;
}

public boolean removeStudent(int roomIn)
{
for(int i = 1;i <= getTotal();i++)
{
if(getStudent(i).getRoom() == roomIn)
{

     remove(i);
return true;
}
}
return false;
}
}
