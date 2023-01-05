package storage;

import model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage{

    //  private Map<String, Resume> map = new HashMap<>();
    // HashMap использовать нельзя при данном  getAll(), потому что не гарантируется порядок
    // какой соблюдается в тесте, по этоу пока используем  TreeMap<>
    private Map<String, Resume> map = new TreeMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, Object uuid) {
        map.put((String) uuid, r);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return map.containsKey((String) uuid);
    }

    @Override
    protected void doSave(Resume r, Object uuid) {
        map.put((String) uuid, r);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return map.get((String) uuid);
    }

    @Override
    protected void doDelete(Object uuid) {
        map.remove((String) uuid);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        List list = new ArrayList<>(map.values());
        return (Resume[]) list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
