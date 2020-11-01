package com.shawn.slot.adapters;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWheelAdapter implements WheelViewAdapter {

    private List<DataSetObserver> dataObservers;

    @Override
    public View getEmptyItem(View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        if (dataObservers == null) {
            dataObservers = new LinkedList<>();
        }
        dataObservers.add(observer);
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
        if (dataObservers != null) {
            dataObservers.remove(observer);
        }
    }

    protected void notifyDataChangedEvent() {
        if (dataObservers != null) {
            for (DataSetObserver observer : dataObservers) {
                observer.onChanged();
            }
        }
    }

    protected void notifyDataInvalidatedEvent() {
        if (dataObservers != null) {
            for (DataSetObserver observer : dataObservers) {
                observer.onInvalidated();
            }
        }
    }
}
