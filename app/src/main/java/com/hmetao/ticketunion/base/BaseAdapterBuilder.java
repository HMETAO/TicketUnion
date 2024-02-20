package com.hmetao.ticketunion.base;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.hmetao.ticketunion.ui.adapter.BaseAdapter;

import java.util.HashMap;

public class BaseAdapterBuilder {

    public static HashMap<Integer, Integer> menusMap = new HashMap<>();
    public static HashMap<Integer, Integer> positionMap = new HashMap<>();
    public static HashMap<Integer, Fragment> fragmentMap = new HashMap<>();

    public static int len = 0;

    private final FragmentActivity fa;

    public BaseAdapterBuilder(FragmentActivity fa) {
        this.fa = fa;
    }

    public BaseAdapterBuilder addFragment(Fragment fragment, int menusId) {
        menusMap.put(len, menusId);
        positionMap.put(menusId, len);
        fragmentMap.put(len++, fragment);
        return this;
    }


    public BaseAdapter build() {
        return new BaseAdapter(fa);
    }

    public static Integer getMenusByPosition(int position) {
        return menusMap.get(position);
    }

    public static Integer getPositionByMenuId(int menuId) {
        return positionMap.get(menuId);
    }
}



