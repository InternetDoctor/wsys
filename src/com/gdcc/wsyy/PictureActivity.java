package com.gdcc.wsyy;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.ByteArrayOutputStream;  
import java.io.InputStream;  
import android.app.Activity;  
import android.app.AlertDialog;  
import android.content.ContentResolver;  
import android.content.DialogInterface;  
import android.content.Intent;  
import android.database.Cursor;  
import android.graphics.Bitmap;  
import android.graphics.BitmapFactory;  
import android.net.Uri;  
import android.os.Bundle;  
import android.provider.MediaStore;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.widget.ImageView;  
  
public class PictureActivity extends Activity {  
    /** Called when the activity is first created. */  
    private ImageView  imageView;  
    private OnClickListener imgViewListener;  
    private Bitmap myBitmap;  
    private byte[] mContent;  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.register);  
        imageView  =(ImageView) findViewById(R.id.picture_back);  
          
        imageView.setOnClickListener(new OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub   
                final CharSequence[] items = { "���", "����" };  
                  
                AlertDialog dlg = new AlertDialog.Builder(PictureActivity.this).setTitle("ѡ����Ƭ").setItems(items,   
                        new DialogInterface.OnClickListener() {  
                              
                            @Override  
                            public void onClick(DialogInterface dialog, int which) {  
                                // TODO Auto-generated method stub   
                            //����item�Ǹ���ѡ��ķ�ʽ��   ��items�������涨�������ַ�ʽ�����յ��±�Ϊ1���Ծ͵������շ���     
                                if(which==1){  
                                    Intent getImageByCamera  = new Intent("android.media.action.IMAGE_CAPTURE");  
                                    startActivityForResult(getImageByCamera, 1);  
                                }else{  
                                    Intent getImage = new Intent(Intent.ACTION_GET_CONTENT);  
                                    getImage.addCategory(Intent.CATEGORY_OPENABLE);  
                                    getImage.setType("image/jpeg");  
                                    startActivityForResult(getImage, 0);  
                                }  
                                  
                            }  
                        }).create();  
                dlg.show();  
            }  
        });  
          
    }  
      
      
    @Override  
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        // TODO Auto-generated method stub   
        super.onActivityResult(requestCode, resultCode, data);  
          
        ContentResolver contentResolver  =getContentResolver();  
         /** 
         * ��Ϊ���ַ�ʽ���õ���startActivityForResult�������������ִ����󶼻�ִ��onActivityResult������ 
         * ����Ϊ�����𵽵�ѡ�����Ǹ���ʽ��ȡͼƬҪ�����жϣ������requestCode��startActivityForResult����ڶ���������Ӧ 
         */  
          
        if(requestCode==0){  
              
            //��ʽһ   
            /*try { 
                 //���ͼƬ��uri  
                Uri orginalUri = data.getData(); 
                  //��ͼƬ���ݽ������ֽ�����  
                mContent = readStream(contentResolver.openInputStream(Uri.parse(orginalUri.toString()))); 
                 //���ֽ�����ת��ΪImageView�ɵ��õ�Bitmap����  
                myBitmap  =getPicFromBytes(mContent,null); 
                  ////�ѵõ���ͼƬ���ڿؼ�����ʾ 
                imageView.setImageBitmap(myBitmap); 
            } catch (Exception e) { 
                e.printStackTrace(); 
                // TODO: handle exception 
            }*/  
              
            //��ʽ��   
            try {  
                Uri selectedImage = data.getData();  
                String[] filePathColumn = { MediaStore.Images.Media.DATA };  
  
                Cursor cursor = getContentResolver().query(selectedImage,  
                        filePathColumn, null, null, null);  
                cursor.moveToFirst();  
  
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);  
                String picturePath = cursor.getString(columnIndex);  
                cursor.close();  
                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));  
            } catch (Exception e) {  
                // TODO: handle exception   
                e.printStackTrace();  
            }  
              
              
        }else if(requestCode==1){  
            try {  
                Bundle extras = data.getExtras();  
                myBitmap = (Bitmap) extras.get("data");  
                ByteArrayOutputStream baos = new ByteArrayOutputStream();       
                myBitmap.compress(Bitmap.CompressFormat.JPEG , 100, baos);       
                mContent=baos.toByteArray();  
            } catch (Exception e) {  
                e.printStackTrace();  
                // TODO: handle exception   
            }  
            imageView.setImageBitmap(myBitmap);  
        }  
          
    }  
      
   public static Bitmap getPicFromBytes(byte[] bytes, BitmapFactory.Options opts) {   
        if (bytes != null)   
            if (opts != null)   
                return BitmapFactory.decodeByteArray(bytes, 0, bytes.length,opts);   
            else   
                return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);   
        return null;   
    }   
      
      
      
 public static byte[] readStream(InputStream in) throws Exception{  
     byte[] buffer  =new byte[1024];  
     int len  =-1;  
     ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
       
     while((len=in.read(buffer))!=-1){  
         outStream.write(buffer, 0, len);  
     }  
     byte[] data  =outStream.toByteArray();  
     outStream.close();  
     in.close();  
     return data;  
 }  
      
}  