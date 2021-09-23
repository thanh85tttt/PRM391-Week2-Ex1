package com.example.helloworld;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> number;
    private ArrayList<Integer> listInt = new ArrayList<>();

    public LiveData<Integer> getNumber(){
        if (number == null){
            number = new MutableLiveData<Integer>();
            number.setValue(0);
        }

        return number;
    }

    public ArrayList<Integer> getListInt() {
        if (listInt == null) {
            listInt = new ArrayList<Integer>();
        }
        return listInt;
    }

    public void increaseNumber(){
        number.setValue(number.getValue() + 1);
    }

    public void decreaseNumber(){
        number.setValue(number.getValue() - 1);
    }

    public void addToList(int number){
        listInt.add(number);
    }

    public void removeFromList(int position){
        listInt.remove(position);
    }
}
