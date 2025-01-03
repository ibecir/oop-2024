package ba.edu.ibu.week13.labs.adapter;

public class Main {
    public static void main(String[] args) {
        // OldDevice instance
        OldDevice oldDevice = new OldDeviceImpl();

        // Using the adapter to make OldDevice compatible with NewDevice interface
        NewDevice adapter = new DeviceAdapter(oldDevice);

        // NewDevice instance
        NewDevice newDevice = new NewDeviceImpl();

        System.out.println("Using NewDevice directly:");
        newDevice.operateNewFunction();

        System.out.println("\nUsing OldDevice through DeviceAdapter:");
        adapter.operateNewFunction();
    }
}
