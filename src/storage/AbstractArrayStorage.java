package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage{
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;


    boolean isOverflow(){
        if (size == STORAGE_LIMIT) {
            System.out.println("Storage overflow!");
            return true;
        }
        return false;
    }
    void showExist(String uuid){
        System.out.println("Sorry! but resume whith uuid " + uuid + " already exist!");
    }
    void showNotExist(String uuid){
        System.out.println("Sorry! but resume whith uuid " + uuid + " is absent!");
    }

    public int size() {
        return size;
    }

    public void clear() {
       Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            showNotExist(r.getUuid());
        } else {
            storage[index] = r;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > 0) {
            showExist(r.getUuid());
        } else if (isOverflow()) {
        } else {
            insertElement(r, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            showNotExist(uuid);
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            showNotExist(uuid);
            return null;
        }
        return storage[index];
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(Resume r, int index);

    protected abstract int getIndex(String uuid);
}
