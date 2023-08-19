/**
 * IPrintTasks performs general printer task and some advanced printer task are separated in different
 * interfaces as they can't be done by all the printers. Hence in this way by separating the functions
 * in different interfaces we have achieved interface segregation principle.
 * 
 * If we keep all the methods in one single interface then we might get stuck in implementing those methods
 * in classes that does not possesses that functionality. hence Interface Segregation becomes more important.
 */
interface IPrintTasks {
    boolean PrintContent(String content);
    boolean ScanContent(String content);
    boolean PhotoCopyContent(String content);
}

interface IFaxContent {
    boolean FaxContent(String content);
}

interface IPrintDuplex {
    boolean DuplexContent(String content);
}

class HpLaserJet implements IPrintTasks, IFaxContent {

    @Override
    public boolean PrintContent(String content) {
        System.out.println("Print done");
        return true;
    }

    @Override
    public boolean ScanContent(String content) {
        System.out.println("Scan done");
        return true;
    }

    @Override
    public boolean FaxContent(String content) {
        System.out.println("Fax done");
        return true;
    }

    @Override
    public boolean PhotoCopyContent(String content) {
        System.out.println("PhotoCopy done");
        return true;
    }

}

class CanonLaserjet implements IPrintTasks, IPrintDuplex {

    @Override
    public boolean DuplexContent(String content) {
        System.out.println("duplex content");
        return true;
    }

    @Override
    public boolean PrintContent(String content) {
        System.out.println("Print content");
        return true;
    }

    @Override
    public boolean ScanContent(String content) {
        System.out.println("Scan content");
        return true;
    }

    @Override
    public boolean PhotoCopyContent(String content) {
        System.out.println("PhotoCopy content");
        return true;
    }
}

public class InterfaceSegregation {

}
