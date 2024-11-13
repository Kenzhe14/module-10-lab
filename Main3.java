class AudioSystem{
    public void TurnOn(){
        System.out.println("Audio system is turned on");
    }
    public void SetVolume(int level){
        System.out.println("Audio volume is set to {level}.");
    }
    public void TurnOff(){
        System.out.println("Audio system is turned off.");
    }
}

class VideoProjector{
    public void TurnOn(){
        System.out.println("Video projector is turned on.");
    }
    public void SetResolution(String resolution){
        System.out.println("Video resolution is set to {resolution}.");
    }
    public void TurnOff(){
        System.out.println("Video projector is turned off.");
    }
}

class LightingSystem{
    public void TurnOn(){
        System.out.println("Lights are turned on.");
    }
    public void SetBrightness(int level){
        System.out.println("Lights brightness is set to {level}.");
    }
    public void TurnOff(){
        System.out.println("Lights are turned off.");;
    }
}

class HomeTheaterFacade{
    private AudioSystem audioSystem;
    private VideoProjector videoProjector;
    private LightingSystem lightingSystem;

    public HomeTheaterFacade(AudioSystem audioSystem, VideoProjector videoProjector, LightingSystem lightingSystem) {
        this.audioSystem = audioSystem;
        this.videoProjector = videoProjector;
        this.lightingSystem = lightingSystem;
    }

    public void StartMovie(){
        System.out.println("Start Film");
        lightingSystem.TurnOn();
        lightingSystem.SetBrightness(3);
        audioSystem.TurnOn();
        audioSystem.SetVolume(10);
        videoProjector.TurnOn();
        videoProjector.SetResolution("FullHd");
        System.out.println("Film started");
    }
    public void EndMovie(){
        System.out.println("Ending movie");
        videoProjector.TurnOff();
        audioSystem.SetVolume(0);
        audioSystem.TurnOff();
        lightingSystem.SetBrightness(1);
        System.out.println("Film ended");
    }

}

public class Main3{
    public static void main(String[] args) {
        AudioSystem audioSystem = new AudioSystem();
        VideoProjector videoProjector = new VideoProjector();
        LightingSystem lightingSystem = new LightingSystem();

        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(audioSystem,videoProjector,lightingSystem);

        homeTheaterFacade.StartMovie();

        System.out.println();

        homeTheaterFacade.EndMovie();
    }
}