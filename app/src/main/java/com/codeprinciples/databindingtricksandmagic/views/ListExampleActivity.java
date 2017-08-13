package com.codeprinciples.databindingtricksandmagic.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Pair;

import com.codeprinciples.databindingtricksandmagic.BR;
import com.codeprinciples.databindingtricksandmagic.R;
import com.codeprinciples.databindingtricksandmagic.adapters.AdapterDataItem;
import com.codeprinciples.databindingtricksandmagic.databinding.ActivityListExampleBinding;
import com.codeprinciples.databindingtricksandmagic.models.Person;
import com.codeprinciples.databindingtricksandmagic.presenters.PersonPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * MIT License
 * <p>
 * Copyright (c) 2017 Oleksiy
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class ListExampleActivity extends AppCompatActivity implements PersonPresenter {
    private ActivityListExampleBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Dynamic List Bindings Example");
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_example);
        mBinding.setListLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mBinding.setModelList(generateModelList());
    }

    private List generateModelList() {
        List<AdapterDataItem> items = new ArrayList<>();
        //Heading
        items.add(new AdapterDataItem(R.layout.layout_item_heading, BR.groupName,"Employees"));
        //Items
        items.add(new AdapterDataItem(
                R.layout.layout_item_info,
                new Pair<Integer, Object>(BR.personModel, new Person("Bob","Smith")),
                new Pair<Integer, Object>(BR.personPresenter, this)));
        items.add(new AdapterDataItem(
                R.layout.layout_item_info,
                new Pair<Integer, Object>(BR.personModel, new Person("Jim","Jacobs")),
                new Pair<Integer, Object>(BR.personPresenter, this)));
        items.add(new AdapterDataItem(
                R.layout.layout_item_info,
                new Pair<Integer, Object>(BR.personModel, new Person("Jane","Peters")),
                new Pair<Integer, Object>(BR.personPresenter, this)));
        items.add(new AdapterDataItem(
                R.layout.layout_item_info,
                new Pair<Integer, Object>(BR.personModel, new Person("Phil","Roberts")),
                new Pair<Integer, Object>(BR.personPresenter, this)));
        //Heading
        items.add(new AdapterDataItem(R.layout.layout_item_heading, BR.groupName,"Volunteers"));
        //Items
        items.add(new AdapterDataItem(
                R.layout.layout_item_info,
                new Pair<Integer, Object>(BR.personModel, new Person("Peter","Bales")),
                new Pair<Integer, Object>(BR.personPresenter, this)));
        items.add(new AdapterDataItem(
                R.layout.layout_item_info,
                new Pair<Integer, Object>(BR.personModel, new Person("Robert","Jameson")),
                new Pair<Integer, Object>(BR.personPresenter, this)));
        return items;
    }

    @Override
    public void onPersonClicked(Person person) {
        Intent intent = new Intent(this,PersonDetailsActivity.class);
        intent.putExtra(PersonDetailsActivity.TAG_PERSON,person);
        startActivity(intent);
    }
}
