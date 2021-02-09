// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.search.documents.indexes.models;

import com.azure.core.rest.annotation.Fluent;
import com.azure.core.serde.SerdeToPojo;
import com.azure.core.serde.SerdeProperty;

/**
 * Represents a synonym map definition.
 */
@Fluent
public final class SynonymMap {
    /*
     * The name of the synonym map.
     */
    @SerdeProperty(value = "name")
    private String name;

    /*
     * A series of synonym rules in the specified synonym map format. The rules
     * must be separated by newlines.
     */
    @SerdeProperty(value = "synonyms")
    private String synonyms;

    /*
     * A description of an encryption key that you create in Azure Key Vault.
     * This key is used to provide an additional level of encryption-at-rest
     * for your data when you want full assurance that no one, not even
     * Microsoft, can decrypt your data in Azure Cognitive Search. Once you
     * have encrypted your data, it will always remain encrypted. Azure
     * Cognitive Search will ignore attempts to set this property to null. You
     * can change this property as needed if you want to rotate your encryption
     * key; Your data will be unaffected. Encryption with customer-managed keys
     * is not available for free search services, and is only available for
     * paid services created on or after January 1, 2019.
     */
    @SerdeProperty(value = "encryptionKey")
    private SearchResourceEncryptionKey encryptionKey;

    /*
     * The ETag of the synonym map.
     */
    @SerdeProperty(value = "@odata.etag")
    private String eTag;

    /**
     * Constructor of {@link SynonymMap}.
     * @param name The name of the synonym map.
     */
    public SynonymMap(String name) {
        this.name = name;
    }

    /**
     * Constructor of {@link SynonymMap}.
     * @param name The name of the synonym map.
     * @param synonyms A series of synonym rules in the specified synonym map format. The rules
     * must be separated by newlines.
     */
    @SerdeToPojo
    public SynonymMap(
        @SerdeProperty(value = "name") String name,
        @SerdeProperty(value = "synonyms") String synonyms) {
        this.name = name;
        this.synonyms = synonyms;
    }

    /**
     * Get the name property: The name of the synonym map.
     *
     * @return the name value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the synonyms property: A series of synonym rules in the specified
     * synonym map format. The rules must be separated by newlines.
     *
     * @return the synonyms value.
     */
    public String getSynonyms() {
        return this.synonyms;
    }

    /**
     * Set the synonyms property: A series of synonym rules in the specified
     * synonym map format. The rules must be separated by newlines.
     *
     * @param synonyms the synonyms value to set.
     * @return the SynonymMap object itself.
     */
    public SynonymMap setSynonyms(String synonyms) {
        this.synonyms = synonyms;
        return this;
    }

    /**
     * Get the encryptionKey property: A description of an encryption key that
     * you create in Azure Key Vault. This key is used to provide an additional
     * level of encryption-at-rest for your data when you want full assurance
     * that no one, not even Microsoft, can decrypt your data in Azure
     * Cognitive Search. Once you have encrypted your data, it will always
     * remain encrypted. Azure Cognitive Search will ignore attempts to set
     * this property to null. You can change this property as needed if you
     * want to rotate your encryption key; Your data will be unaffected.
     * Encryption with customer-managed keys is not available for free search
     * services, and is only available for paid services created on or after
     * January 1, 2019.
     *
     * @return the encryptionKey value.
     */
    public SearchResourceEncryptionKey getEncryptionKey() {
        return this.encryptionKey;
    }

    /**
     * Set the encryptionKey property: A description of an encryption key that
     * you create in Azure Key Vault. This key is used to provide an additional
     * level of encryption-at-rest for your data when you want full assurance
     * that no one, not even Microsoft, can decrypt your data in Azure
     * Cognitive Search. Once you have encrypted your data, it will always
     * remain encrypted. Azure Cognitive Search will ignore attempts to set
     * this property to null. You can change this property as needed if you
     * want to rotate your encryption key; Your data will be unaffected.
     * Encryption with customer-managed keys is not available for free search
     * services, and is only available for paid services created on or after
     * January 1, 2019.
     *
     * @param encryptionKey the encryptionKey value to set.
     * @return the SynonymMap object itself.
     */
    public SynonymMap setEncryptionKey(SearchResourceEncryptionKey encryptionKey) {
        this.encryptionKey = encryptionKey;
        return this;
    }

    /**
     * Get the eTag property: The ETag of the synonym map.
     *
     * @return the eTag value.
     */
    public String getETag() {
        return this.eTag;
    }

    /**
     * Set the eTag property: The ETag of the synonym map.
     *
     * @param eTag the eTag value to set.
     * @return the SynonymMap object itself.
     */
    public SynonymMap setETag(String eTag) {
        this.eTag = eTag;
        return this;
    }
}