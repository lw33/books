package lw.learning.dp.pattern.behavior.state;

/**
 * @Author lw
 * @Date 2018-12-18 18:04:29
 **/
public class VideoStateContext {
    private VideoState videoState;
    public static final PlayState PLAY_STATE = new PlayState();
    public static final PauseState PAUSE_STATE = new PauseState();
    public static final SpeedState SPEED_STATE = new SpeedState();
    public static final StopState STOP_STATE = new StopState();


}
