import java.util.List;
import java.util.ArrayList;

abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    abstract void Display(int depth);

    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public FileSystemComponent getChild(int index) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}

class File extends FileSystemComponent {
    private String name;

    public File(String name) {
        super(name);
        this.name = name;
    }

    @Override
    void Display(int depth) {
        System.out.println(new String(new char[depth]).replace("\0", "-") + " File: " + name);
    }
}

class Directory extends FileSystemComponent {
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public FileSystemComponent getChild(int index) {
        return children.get(index);
    }

    @Override
    public void Display(int depth) {
        System.out.println(new String(new char[depth]).replace("\0", "-") + " Directory: " + name);
        for (FileSystemComponent component : children) {
            component.Display(depth + 2);
        }
    }
}

public class Composite {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        File file = new File("File 1");
        File file2 = new File("File 2");

        Directory subdir = new Directory("Sub dir");
        File subfile = new File("Sub file");

        Directory subsubdir = new Directory("Sub sub dir");
        File subsubfile = new File("Sub sub file");

        root.add(file);
        root.add(file2);

        subdir.add(subfile);
        root.add(subdir);

        subsubdir.add(subsubfile);
        subdir.add(subsubdir);

        root.Display(1);
    }
}