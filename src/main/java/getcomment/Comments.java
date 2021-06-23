package getcomment;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Comments {
    private String self;
    private String id;
    private Author author;
    private UpdateAuthor updateAuthor;
    private Visibility visibility;
    private String body;
    private String created;
    private String updated;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public UpdateAuthor getUpdateAuthor() {
        return updateAuthor;
    }

    public void setUpdateAuthor(UpdateAuthor updateAuthor) {
        this.updateAuthor = updateAuthor;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public class Author {
        private String self;
        private String name;
        private String key;
        private String emailAddress;
        private String displayName;
        private String active;
        private String timeZone;
        @JsonIgnore
        private AvatarUrls avatarUrls;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public String getTimeZone() {
            return timeZone;
        }

        public void setTimeZone(String timeZone) {
            this.timeZone = timeZone;
        }

        public AvatarUrls getAvatarUrls() {
            return avatarUrls;
        }

        public void setAvatarUrls(AvatarUrls avatarUrls) {
            this.avatarUrls = avatarUrls;
        }

        public class AvatarUrls{
            private String four;
            private String twofour;
            private String onesix;
            private String threetwo;
            @JsonIgnore
            public String getFour() {
                return four;
            }
            @JsonIgnore
            public void setFour(String four) {
                this.four = four;
            }
            @JsonIgnore
            public String getTwofour() {
                return twofour;
            }
            @JsonIgnore
            public void setTwofour(String twofour) {
                this.twofour = twofour;
            }
            @JsonIgnore
            public String getOnesix() {
                return onesix;
            }
            @JsonIgnore
            public void setOnesix(String onesix) {
                this.onesix = onesix;
            }
            @JsonIgnore
            public String getThreetwo() {
                return threetwo;
            }
            @JsonIgnore
            public void setThreetwo(String threetwo) {
                this.threetwo = threetwo;
            }
        }

    }

    public class UpdateAuthor {
        private String self;
        private String name;
        private String key;
        private String emailAddress;
        private String displayName;
        private String active;
        private String timeZone;
        @JsonIgnore
        private AvatarUrls avatarUrls;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }

        public String getTimeZone() {
            return timeZone;
        }

        public void setTimeZone(String timeZone) {
            this.timeZone = timeZone;
        }

        public AvatarUrls getAvatarUrls() {
            return avatarUrls;
        }

        public void setAvatarUrls(AvatarUrls avatarUrls) {
            this.avatarUrls = avatarUrls;
        }

        public class AvatarUrls{
            @JsonIgnore
            private String four;
            @JsonIgnore
            private String twofour;
            @JsonIgnore
            private String onesix;
            @JsonIgnore
            private String threetwo;
            @JsonIgnore
            public String getFour() {
                return four;
            }
            @JsonIgnore
            public void setFour(String four) {
                this.four = four;
            }
            @JsonIgnore
            public String getTwofour() {
                return twofour;
            }
            @JsonIgnore
            public void setTwofour(String twofour) {
                this.twofour = twofour;
            }
            @JsonIgnore
            public String getOnesix() {
                return onesix;
            }
            @JsonIgnore
            public void setOnesix(String onesix) {
                this.onesix = onesix;
            }
            @JsonIgnore
            public String getThreetwo() {
                return threetwo;
            }
            @JsonIgnore
            public void setThreetwo(String threetwo) {
                this.threetwo = threetwo;
            }
        }

    }

    public class Visibility {
        private String type;
        private String value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
