package model;

import java.util.UUID;

public class Resume {
    private String uuid;
    public Resume(String uuid) {
        this.uuid = uuid;
    }
    public Resume () {
        this(UUID.randomUUID().toString());
    }



    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }


}
