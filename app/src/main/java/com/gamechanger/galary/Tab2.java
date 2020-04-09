package com.gamechanger.galary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.Objects;

import static android.app.Activity.RESULT_OK;


public class Tab2 extends Fragment {
    Context context;
    ImageView img2;
    private int PICK_IMAGE_REQ=1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_tab1,container,false);
        img2=rootView.findViewById(R.id.img1);
        img2.setImageResource(R.mipmap.ic_launcher);
        // Inflate the layout for this fragment
        return rootView;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu1,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.setImg)
        {

            chooseImage();
//            Toast.makeText(getActivity(),"Tab2",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    public void chooseImage()
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),PICK_IMAGE_REQ);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE_REQ && resultCode== RESULT_OK && data!=null)
        {
            Uri uri=data.getData();
            try {
//                Bitmap bitmap=MediaStore.Images.Media.getBitmap(Objects.requireNonNull(this.getActivity()).getContentResolver(),uri);
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),uri);
                img2.setImageBitmap(bitmap);

            } catch (IOException e) {
                Toast.makeText(getActivity(),"went wrong",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }
}
