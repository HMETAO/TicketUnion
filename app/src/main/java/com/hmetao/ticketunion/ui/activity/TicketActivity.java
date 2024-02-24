package com.hmetao.ticketunion.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hmetao.ticketunion.databinding.ActivityTicketBinding;
import com.hmetao.ticketunion.model.domain.TicketResult;
import com.hmetao.ticketunion.view.TicketCallback;

public class TicketActivity extends AppCompatActivity implements TicketCallback {

    private ActivityTicketBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTicketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void networkError() {

    }

    @Override
    public void networkLoading() {

    }

    @Override
    public void networkEmpty() {

    }

    @Override
    public void networkSuccess() {

    }

    @Override
    public void onTicketLoaded(String cover, TicketResult result) {

    }
}