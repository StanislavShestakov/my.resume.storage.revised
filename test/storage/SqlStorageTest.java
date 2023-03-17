package storage;

import conf.Config;

public class SqlStorageTest extends AbstractStorageTest{
    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}
