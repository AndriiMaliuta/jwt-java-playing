https://github.com/jwtk/jjwt

NOTE: You do not need to set the alg or zip header parameters as JJWT will set them automatically depending on the
signature algorithm or compression algorithm used.

### Signature Algorithms Keys

- HS256: HMAC using SHA-256
- HS384: HMAC using SHA-384
- HS512: HMAC using SHA-512
- ES256: ECDSA using P-256 and SHA-256
- ES384: ECDSA using P-384 and SHA-384
- ES512: ECDSA using P-521 and SHA-512
- RS256: RSASSA-PKCS-v1_5 using SHA-256
- RS384: RSASSA-PKCS-v1_5 using SHA-384
- RS512: RSASSA-PKCS-v1_5 using SHA-512
- PS256: RSASSA-PSS using SHA-256 and MGF1 with SHA-256
- PS384: RSASSA-PSS using SHA-384 and MGF1 with SHA-384
- PS512: RSASSA-PSS using SHA-512 and MGF1 with SHA-512

### Claims
- setIssuer: sets the iss (Issuer) Claim
- setSubject: sets the sub (Subject) Claim
- setAudience: sets the aud (Audience) Claim
- setExpiration: sets the exp (Expiration Time) Claim
- setNotBefore: sets the nbf (Not Before) Claim
- setIssuedAt: sets the iat (Issued At) Claim
- setId: sets the jti (JWT ID) Claim

