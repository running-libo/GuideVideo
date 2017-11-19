package com.example.guidvideo.guidevideo;


import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.VideoView;
import butterknife.ButterKnife;

public class GuidePagerFragment extends LazyLoadFragment implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private VideoView videoviewGuide;
    private int curPage;
    private boolean mHasPaused;

    @Override
    protected int setContentView() {
        return R.layout.fragment_guide_pager;
    }

    @Override
    protected void stopLoad() {
        super.stopLoad();
        if (videoviewGuide != null) {
            videoviewGuide.stopPlayback();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    protected void lazyLoad() {
        if (getArguments() == null) {
            return;
        }
        videoviewGuide = findViewById(R.id.videoview_guide);
        int videoRes = getArguments().getInt("res");
        curPage = getArguments().getInt("page");
        videoviewGuide.setOnPreparedListener(this);
        videoviewGuide.setVideoPath("android.resource://" + getActivity().getPackageName() + "/" + videoRes);

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        if (videoviewGuide != null) {
            videoviewGuide.requestFocus();
            videoviewGuide.seekTo(0);
            videoviewGuide.start();
            videoviewGuide.setOnCompletionListener(this);
        }
        return;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mHasPaused) {
            if (videoviewGuide != null) {
                videoviewGuide.seekTo(curPage);
                videoviewGuide.resume();
            }
        }
        return;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (videoviewGuide != null) {
            curPage = videoviewGuide.getCurrentPosition();
        }
        mHasPaused = true;
    }

    public void onDestroy() {
        super.onDestroy();
        if (videoviewGuide != null) {
            videoviewGuide.stopPlayback();
        }
        return;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        ((GuidePagerActivity)getActivity()).next(curPage);
    }
}
