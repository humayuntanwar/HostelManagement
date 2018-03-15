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
public class RecordList {

    private Object[] list;
    private int total;
    public RecordList(){
        list=null;
        total=0;
    }

    public RecordList(int sizeIn) {
        list = new Object[sizeIn];
        total = 0;
    }

    public boolean add(Object objectIn) {
        if (!isFull()) {
            list[total] = objectIn;
            total++;
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (total == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (total == list.length) {
            return true;
        } else {
            return false;
        }
    }

    public Object getItem(int indexIn) {
        if (indexIn < 1 || indexIn > total) {
            return null;
        } else {
            return list[indexIn - 1];
        }
    }

    public int getTotal() {
        return total;
    }

    public boolean remove(int indexIn) {
        if (indexIn >= 1 && indexIn <= total) {
            for (int i = indexIn - 1; i <= total - 2; i++) {
                list[i] = list[i + 1];
            }
            total--;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String items = "";
        for (int i = 0; i < total; i++) {
            items = items + list[i].toString() + " ";
        }
        return "[ " + items + "]";
    }
    

}
