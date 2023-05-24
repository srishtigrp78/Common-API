package com.iemr.common.service.kmfilemanager;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.iemr.common.utils.exception.IEMRException;

public interface KMFileManagerService
{
	String getKMFileLists(String request) throws Exception;

	Integer updateKMFileManager(String request) throws Exception;

	String addKMFile(String request) throws IOException, NoSuchAlgorithmException, IEMRException;
}
