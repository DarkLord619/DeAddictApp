package com.example.ganeshjanani.myapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

//import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeNoticeDialog;
//import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;

public class PasswordFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v=inflater.inflate(R.layout.passwordlayout,container,false);
        Button pasbtn=v.findViewById(R.id.pasbutton);
        pasbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new AwesomeNoticeDialog(getContext())
//                        .setTitle(R.string.app_name)
//                        .setMessage("Be sure to remember the password.This is the master password. This password will be required to block the app/unblock the app")
//                        .setColoredCircle(R.color.dialogWarningBackgroundColor)
//                        .setDialogIconAndColor(R.drawable.ic_dialog_info, R.color.white)
//                        .setCancelable(true)
//                        .setButtonText(getString(R.string.dialog_ok_button))
//                        .setButtonBackgroundColor(R.color.dialogWarningBackgroundColor)
//                        .setButtonText(getString(R.string.dialog_ok_button))
//                        .setNoticeButtonClick(new Closure() {
//                            @Override
//                            public void exec() {
//                                // click
//                                Toast.makeText(getContext(),"Password saved",Toast.LENGTH_SHORT).show();
//                            }
//                        })
//                        .show();
            }
        });
        return  v;





    }
}
