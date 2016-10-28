package com.example.sqlitedatabases;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Anand on 28/10/2016.
 */

public class ShowUsersActivity extends AppCompatActivity implements OnItemClickListener {

    private UsersDB usersDB;
    private List<User> users;
    private RecyclerView recyclerView;
    private ShowUsersAdapter showUsersAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_users);

        usersDB = new UsersDB(this);
        users = usersDB.getUsers();

        recyclerView = (RecyclerView) findViewById(R.id.show_users_recycler_view);
        recyclerView.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        showUsersAdapter = new ShowUsersAdapter(users);
        recyclerView.setAdapter(showUsersAdapter);

        showUsersAdapter.setClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, users.get(position).getFirstName(), Toast.LENGTH_SHORT).show();
    }
}
