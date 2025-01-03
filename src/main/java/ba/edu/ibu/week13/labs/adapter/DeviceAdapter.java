package ba.edu.ibu.week13.labs.adapter;

public class DeviceAdapter implements NewDevice{
    private OldDevice oldDevice;

    public DeviceAdapter(OldDevice oldDevice) {
        this.oldDevice = oldDevice;
    }

    @Override
    public void operateNewFunction() {
        this.oldDevice.operateOldFunction();
    }
}
