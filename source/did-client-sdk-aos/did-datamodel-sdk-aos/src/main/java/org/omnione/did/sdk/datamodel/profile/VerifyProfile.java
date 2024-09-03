/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.profile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.omnione.did.sdk.datamodel.common.Proof;
import org.omnione.did.sdk.datamodel.common.enums.VerifyAuthType;
import org.omnione.did.sdk.datamodel.common.ProofContainer;
import org.omnione.did.sdk.datamodel.util.IntEnumAdapterFactory;
import org.omnione.did.sdk.datamodel.common.enums.CredentialSchemaType;

import java.util.List;

public class VerifyProfile implements ProofContainer {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("type")
    @Expose
    private ProfileType.PROFILE_TYPE type;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("logo")
    @Expose
    private LogoImage logo;

    @SerializedName("encoding")
    @Expose
    private String encoding;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("profile")
    @Expose
    private Profile profile;

    @SerializedName("proof")
    @Expose
    private Proof proof;

    @SerializedName("proofs")
    @Expose
    private List<Proof> proofs;


    public static class Profile {
        public ProviderDetail verifier;
        public ProfileFilter filter;
        public Process process;

        public ProviderDetail getVerifier() {
            return verifier;
        }

        public void setVerifier(ProviderDetail verifier) {
            this.verifier = verifier;
        }

        public ProfileFilter getFilter() {
            return filter;
        }

        public void setFilter(ProfileFilter filter) {
            this.filter = filter;
        }

        public Process getProcess() {
            return process;
        }

        public void setProcess(Process process) {
            this.process = process;
        }
    }
        public static class ProfileFilter {
            private List<CredentialSchema> credentialSchemas;

            public List<CredentialSchema> getCredentialSchemas() {
                return credentialSchemas;
            }

            public void setCredentialSchemas(List<CredentialSchema> credentialSchemas) {
                this.credentialSchemas = credentialSchemas;
            }

        }

        public static class CredentialSchema {
            public String id;
            public CredentialSchemaType.CREDENTIAL_SCHEMA_TYPE type;
            public String value;
            public List<String> displayClaims;
            public List<String> requiredClaims;
            public List<String> allowedIssuers;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public CredentialSchemaType.CREDENTIAL_SCHEMA_TYPE getType() {
                return type;
            }

            public void setType(CredentialSchemaType.CREDENTIAL_SCHEMA_TYPE type) {
                this.type = type;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public List<String> getDisplayClaims() {
                return displayClaims;
            }

            public void setDisplayClaims(List<String> displayClaims) {
                this.displayClaims = displayClaims;
            }

            public List<String> getRequiredClaims() {
                return requiredClaims;
            }

            public void setRequiredClaims(List<String> requiredClaims) {
                this.requiredClaims = requiredClaims;
            }

            public List<String> getAllowedIssuers() {
                return allowedIssuers;
            }

            public void setAllowedIssuers(List<String> allowedIssuers) {
                this.allowedIssuers = allowedIssuers;
            }
        }

        public static class Process {
            public List<String> endpoints;
            public ReqE2e reqE2e;
            public String verifierNonce;
            public VerifyAuthType.VERIFY_AUTH_TYPE authType;

            public List<String> getEndpoints() {
                return endpoints;
            }

            public void setEndpoints(List<String> endpoints) {
                this.endpoints = endpoints;
            }

            public ReqE2e getReqE2e() {
                return reqE2e;
            }

            public void setReqE2e(ReqE2e reqE2e) {
                this.reqE2e = reqE2e;
            }

            public String getVerifierNonce() {
                return verifierNonce;
            }

            public void setVerifierNonce(String verifierNonce) {
                this.verifierNonce = verifierNonce;
            }

            public VerifyAuthType.VERIFY_AUTH_TYPE getAuthType() {
                return authType;
            }

            public void setAuthType(VerifyAuthType.VERIFY_AUTH_TYPE authType) {
                this.authType = authType;
            }
        }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProfileType.PROFILE_TYPE getType() {
        return type;
    }

    public void setType(ProfileType.PROFILE_TYPE type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LogoImage getLogo() {
        return logo;
    }

    public void setLogo(LogoImage logo) {
        this.logo = logo;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Proof getProof() {
        return proof;
    }

    public void setProof(Proof proof) {
        this.proof = proof;
    }

    @Override
    public List<Proof> getProofs() {
        return proofs;
    }

    @Override
    public void setProofs(List<Proof> proofs) {
        this.proofs = proofs;
    }

    public void fromJson(String val) {
        Gson gson = new Gson();
        VerifyProfile obj = gson.fromJson(val, VerifyProfile.class);

        this.id = obj.getId();
        this.type = obj.getType();
        this.title = obj.getTitle();
        this.description = obj.getDescription();
        this.logo = obj.getLogo();
        this.encoding = obj.getEncoding();
        this.language = obj.getLanguage();
        this.profile = obj.getProfile();
        this.proof = obj.getProof();
        this.proofs = obj.getProofs();

    }

    public String toJson() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new IntEnumAdapterFactory())
                //.registerTypeAdapterFactory(new StringEnumAdapterFactory())
                .create();

        String json = gson.toJson(this);
        return json;
        //return ODIJsonSortUtil.sortJsonString(gson, json);
    }
}