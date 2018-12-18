package lw.learning.dp.pattern.behavior.state;

/**
 * @Author lw
 * @Date 2018-12-18 18:04:11
 **/
public abstract class VideoState {

    protected VideoStateContext videoStateContext;

    public void setVideoStateContext(VideoStateContext videoStateContext) {
        this.videoStateContext = videoStateContext;
    }

    public abstract void play();
    public abstract void speed();
    public abstract void pause();
    public abstract void stop();

}
