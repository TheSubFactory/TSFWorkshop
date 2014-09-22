package net.TheSubFactory.tsfworkshop;

import java.util.ArrayList;

import net.TheSubFactory.tsfworkshop.FileSelectFragment.Mode;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity implements FileSelectFragment.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
       
    }

	@Override
	public void onConfirmSelect(String absolutePath, String fileName) {
		if (absolutePath != null && fileName != null) {
		      // Recommend that long/intensive file processes be handled by an
		      // Async task.
		      //myFileProcess(absolutePath, fileName);
		}
	}


	@Override
	public boolean isValid(String absolutePath, String fileName) {
		//return fileHeaderCheck(absolutePath, fileName);
		return true;
	}


	//@Override
	//public boolean onCanSave(String absolutePath, String fileName) {
		// TODO Auto-generated method stub
	//	return false;
	//}


	//@Override
	//public void onConfirmSave(String absolutePath, String fileName) {
		// TODO Auto-generated method stub
		
	//}
	
	 
    public void showSelectDialog(View view)
    {
    	String fragTag = getResources().getString(R.string.tag_fragment_FileSelect);

    	  // Set up a selector for file selection rather than directory selection.
    	  FileSelectFragment fsf = FileSelectFragment.newInstance(Mode.FileSelector, 
    	                                                          R.string.alert_ok,
    	                                                          R.string.alert_cancel, 
    	                                                          R.string.alert_file_select,
    	                                                          R.drawable.tsf_launcher, 
    	                                                          R.drawable.tsf_dir,
    	                                                          R.drawable.tsf_file);

    	  // Restrict selection to *.srt files
    	  ArrayList<String> allowedExtensions = new ArrayList<String>();
    	  allowedExtensions.add(".srt");
    	  fsf.setFilter(FileSelectFragment.FiletypeFilter(allowedExtensions));

    	  fsf.show(getFragmentManager(), fragTag);
    }

}
